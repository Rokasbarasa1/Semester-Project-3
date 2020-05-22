﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using BusinessLogic.Model.Shared;

namespace BusinessLogic.Model.Calendar
{
    public class Shift
    {
        public int Id { get; set; }
        public int UserId { get; set; }
        public string Description { get; set; }
        public string Status { get; set; }
        public int ManagerId { get; set; }
        private DateTime Date { get; set; }
    }
}
