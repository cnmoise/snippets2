using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace TeamDLCFoodShop.Models
{
    public class FoodRepository : IFoodRepository
    {
        private readonly AppDbContext _appDbContext;

        public FoodRepository(AppDbContext appDbContext) {
            _appDbContext = appDbContext;
        }

        public IEnumerable<Food> GetAllFoods()
        {
            return _appDbContext.Foods;
        }

        public Food GetFoodById(int foodId)
        {
            return _appDbContext.Foods.FirstOrDefault(f=> f.Id == foodId);
        }


    }
}
