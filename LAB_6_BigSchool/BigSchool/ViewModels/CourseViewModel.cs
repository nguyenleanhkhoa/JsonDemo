﻿using BigSchool.Models;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Globalization;
using System.Linq;
using System.Web;

namespace BigSchool.ViewModels
{
    public class CourseViewModel
    {
        [Required]
        public string Place { get; set; }
        [Required]
        [FutureDate]
        public string Date { get; set; }
        [Required]
        [ValidTime]
        public string Time { get; set; }
        [Required]
        public byte Category { get; set; }
        public IEnumerable<Category> Categories { get; set; }

        public DateTime GetDateTime()
        {
            DateTime dateTime;
            var isValid = DateTime.TryParseExact(Convert.ToString(Date),
                "dd/M/yyyy",
                CultureInfo.CurrentCulture,
                DateTimeStyles.None, out dateTime);

            return DateTime.Parse(string.Format("{0} {1}", dateTime.ToShortDateString(), Time));
        }
    }
}