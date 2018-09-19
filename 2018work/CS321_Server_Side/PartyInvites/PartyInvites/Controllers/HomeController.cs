using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
//Connects us to the model class
using PartyInvites.Models;

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

        [HttpGet]
        public ViewResult RsvpForm()
        {

            return View();

        }

        //2 controlers invoked
        [HttpPost]
        public ViewResult RsvpForm(GuestResponse guestResponse)
        {
            return View("Thanks", guestResponse);

        }


    }
}