using Microsoft.VisualStudio.TestTools.UnitTesting;
using StubsAndShimsDemo;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StubsAndShimsDemo.Tests
{
    [TestClass()]
    public class StockAnalyzerTests
    {
        [TestMethod()]
        public void TestGetContosoPriceValidCompany()
        {
            int expectedPrice = 999;
            int priceToReturn = -1;
            string companyCodeUsed = null;

            IStockFeed stubFeed = new Fakes.StubIStockFeed()
            {
                GetSharePriceString = company =>
                {
                    companyCodeUsed = company;
                    if (company == "COOO")
                    {
                        priceToReturn = expectedPrice;
                    } else
                    {
                        priceToReturn = 0;
                    }

                    return priceToReturn;
                }
            };

            var sa = new StockAnalyzer(stubFeed);
            // Test that the price matches the one returned
            Assert.AreEqual(sa.GetContosoPrice(), priceToReturn);
            // Test that the price returned is as expected
            Assert.AreEqual(priceToReturn, expectedPrice);
            // Test that the company given is as expected
            Assert.AreEqual(companyCodeUsed, "COOO");
        }

        [TestMethod()]
        public void TestGetContosoPriceInvalidCompany()
        {
            int expectedPrice = 0;
            int priceToReturn = -1;
            string companyCodeUsed = null;

            IStockFeed stubFeed = new Fakes.StubIStockFeed()
            {
                GetSharePriceString = (company) =>
                {
                    companyCodeUsed = company;
                    if (company == "ABC")
                    {
                        priceToReturn = 999;
                    }
                    else
                    {
                        priceToReturn = expectedPrice;
                    }

                    return priceToReturn;
                }
            };

            var sa = new StockAnalyzer(stubFeed);
            // Test that the price matches the one returned
            Assert.AreEqual(sa.GetContosoPrice(), priceToReturn);
            // Test that the price returned is as expected
            Assert.AreEqual(priceToReturn, expectedPrice);
            // Test that the company given is as expected
            Assert.AreEqual(companyCodeUsed, "COOO");
        }

        [TestMethod()]
        public void TestGetContosoPriceGetterSetter()
        {
            // Create stub
            var fakeFeed = new Fakes.StubIStockFeed();
            IStockFeed stubFeed = fakeFeed;

            // Prepare the stub
            int stubVal = 0; // A variable to save value in the getter and setter
            fakeFeed.MySampleValueGet = () => stubVal;
            fakeFeed.MySampleValueSetInt32 = value => stubVal = value;

            // Make the share price depend on MySampleValue
            fakeFeed.GetSharePriceString = company => stubFeed.MySampleValue;

            // Set MySampleValue to the value we want to test against
            int expectPrice = 123;
            stubFeed.MySampleValue = expectPrice;

            var sa = new StockAnalyzer(stubFeed);

            // Test that the price matches what we expect which we MySampleValue as
            Assert.AreEqual(sa.GetContosoPrice(), expectPrice);
        }

        [TestMethod()]
        public void TestStockFeedGenericMethod()
        {
            // Create stub
            var fakeFeed = new Fakes.StubIStockFeed();
            IStockFeed stubFeed = fakeFeed;

            // Prepare the stub with an expected value to test against
            int expectPrice = 123;
            fakeFeed.GetValueOf1(() => expectPrice);

            // Make the share price depend on MySampleValue
            fakeFeed.GetSharePriceString = company => stubFeed.GetValue<int>();

            var sa = new StockAnalyzer(stubFeed);

            // Test that the price matches what we expect which we MySampleValue as
            Assert.AreEqual(sa.GetContosoPrice(), expectPrice);
        }
    }
}