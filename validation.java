package sample;

import java.util.HashMap;


    public class validation {

        HashMap users;
        public validation()
        {
            users.put("Ahmed","12345");
            users.put("Samira","123");
            users.put("toka","1999");

        }

        public boolean validate (String name , int carndNumber)
        {
            boolean result = false;
            String username;
            username = (String) users.get(name);
            if(username!=null)
            {
                result = username.equals(carndNumber);
            }
            return  result;
        }



    }


