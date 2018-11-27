using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using BethanysPieShop2.Models;
using BethanysPieShop2.Models.ViewModels;

namespace BethanysPieShop2.Controllers
{
    public class HomeController : Controller
    {
        private readonly IPieRepository _pieRepository;

        public IActionResult Index()
        { //ViewBag.Title = "Pie overiew"; //Remove to add HomeViewModel
            var pies = _pieRepository.GetAllPies().OrderBy(p => p.Name);
            var homeViewModel = new HomeViewModel()
            {
                Title = "Welcome to Bethany's Pie Shop", //note: comma
                Pies = pies.ToList() //note: no semicolon here
            }; //note: semicolon here
            return View(homeViewModel);
        }

        public HomeController(IPieRepository pieRepository) {
            _pieRepository = pieRepository;
        }
    }
}