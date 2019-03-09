using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using TeamDLCFoodShop.Models;
using TeamDLCFoodShop.Models.ViewModels;

namespace TeamDLCFoodShop.Controllers
{
    public class HomeController : Controller
    {
        private readonly IFoodRepository _foodRepository;


        public HomeController(IFoodRepository foodRepository)
        {
            _foodRepository = foodRepository;
        }

        public IActionResult Index()
        { //ViewBag.Title = "Food overiew"; //Remove to add HomeViewModel
            var foods = _foodRepository.GetAllFoods().OrderBy(p => p.Name);
            var homeViewModel = new HomeViewModel()
            {
                Title = "Welcome to Team DLC's Food Shop", //note: comma
                Foods = foods.ToList() //note: no semicolon here
            }; //note: semicolon here
            return View(homeViewModel);
        }

        public IActionResult Details(int id)
        {
            var food = _foodRepository.GetFoodById(id);
            if (food == null)
                return NotFound();

            return View(food);
        }
    }
}