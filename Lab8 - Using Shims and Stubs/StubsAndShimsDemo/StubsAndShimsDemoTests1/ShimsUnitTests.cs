using Microsoft.QualityTools.Testing.Fakes;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using StubsAndShimsDemo;
using System;
using System.Collections.Generic;
using System.Fakes;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StubsAndShimsDemo.Tests
{
    [TestClass()]
    public class ShimsUnitTests
    {
        // Checks that the Y2KChecker.check method throws the exact error (with the exact message)
        [TestMethod()]
        public void CheckTestY2K()
        {
            using (ShimsContext.Create()) // Use a shim to fake the date of the system
            {
                try
                {
                    ShimDateTime.NowGet = () => new DateTime(2000, 1, 1); // Override the current date to 1 Jan 2000
                    var y2k = new Y2KChecker();
                    y2k.Check();
                    Assert.Fail("Expected exception after calling y2k.Check!");
                }
                catch (ApplicationException e)
                {
                    Assert.AreEqual(e.Message, "y2kbug!");
                }
                catch (Exception)
                {
                    Assert.Fail("Expected ApplicationException after calling y2k.Check!");
                }
            }
        }

        // Checks that the Y2KChecker.check method returns the current year as expected
        [TestMethod()]
        public void CheckTestToday()
        {
            var y2k = new Y2KChecker();
            Assert.AreEqual(y2k.Check(), DateTime.Now.Year);
        }
    }
}