using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;


namespace TeamDLCFoodShop.Models
{
    public interface IFoodRepository
    {
        IEnumerable<Food> GetAllFoods();
        Food GetFoodById(int foodId);
    }
}
