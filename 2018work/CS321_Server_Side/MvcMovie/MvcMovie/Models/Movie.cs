using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.Entity;

namespace MvcMovie.Models
{
    //This is a model
    //like a row in a DB
    public class Movie
    {
        public int ID { get; set; }
        public string Title { get; set; }
        public DateTime ReleaseDate { get; set; }
        public string Genre { get; set; }
        public decimal Price { get; set; }
    }

    //Entity FrameWork, handles fetching, storing and updating movie class instances in a DB

    //must isnstal package by right clicking & choosing "Manage Nugget Packages"
    //creates a LocalDB
    public class MoviewDBContext : DbContext
    {
        public DbSet<Movie> Movies { get; set; }
    }
}

