package com.saathi.common

import java.util.regex.Pattern

 object ValidationUtils
 {
     fun isValidUpiId(upiId: String): Boolean {
         // Define the UPI ID pattern
         val upiPattern = Pattern.compile("^[a-zA-Z0-9.\\-_]{2,256}@[a-zA-Z]{2,64}$")
         return upiPattern.matcher(upiId).matches()
     }
 }