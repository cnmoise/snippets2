using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace PartyInvites.Controllers
{
    public class HomeController : Controller
    {
        // GET: Home
        //needs to match the Index  View
        public ActionResult Index()
        {
            int hour = DateTime.Now.Hour;
            //Ternary Operator
            //Creates a new property
            ViewBag.Greeting = hour < 12 ? "Good Morning" : "Good Afternoon";

            return View();
        }

        public ViewResult RsvpForm()
        {

            return View();

        }
    }
}