package assignment;

import java.text.DecimalFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Javiery
 */
public class Methods {

    public static String bmi(double weight, double height) {
        String output = "";
        DecimalFormat formatter = new DecimalFormat("#0.00"); //formats bmi to 2 d.p
        double bmi = weight / (height * height);
        output += ("Your BMI is " + formatter.format(bmi) + "\n");
        if (bmi < 16.0) {
            output += ("You are seriously underweight");
        } else if (bmi < 18.0) {
            output += ("You are underweight");
        } else if (bmi < 24.0) {
            output += ("You are noraml weight");
        } else if (bmi < 29.0) {
            output += ("You are  overweight");
            output += ("Limit Snacks - Refrain from unhealthy snacks such as potato chips and ice cream."
                    + "\n Instead eat healthy snacks such as fruits and nuts."
                    + "\n ");
        } else if (bmi < 35.0) {
            output += ("You are seriously overweight");
            output += ("Make sure you get at least 150 minutes of moderate-intensity aerobic activity(e.g Swimming/Cycling/Badminton) per week for optimum weight loss.");
        }
        return output;
    } //end of bmi method

    //display facts in BotV2 class
    public static String getOutput() {
        String output = "";
        int decider = (int) (Math.random() * 6 + 1);
        switch (decider) {
            case 1:
                output += ("Community Health Assist Scheme (CHAS) enables Singapore Citizens which is broken down to three categories: (CHAS Blue [lower income], CHAS Orange[medium income, "
                        + "\nand Pioneer Generation) to have subsides at participating GPs and dental clinics (up to $28.50 subsidy per visit to a GP).");
                break;
            case 2:
                output += ("Singapore has the second-highest proportion of diabeties of 10.53%, "
                        + "\nas Singaporeans are becoming less active and eating more high-calorie diets");
                break;
            case 3:
                output += ("If you are trying to lose weight, "
                        + "\nmake sure you get at least 150 minutes of moderate-intensity aerobic activity per week for optimum weight loss.");
                break;
            case 4:
                output += ("Of the 526,000 visits at polyclincs in 2016, 15% was because of hyperlipedemia (which is due to high cholesterol)");
            case 5:
                output += ("Obesity can occur in early childhood - 12% of schoolchildren are overweight.");
                break;
            case 6:
                output += ("More Singaporeans are exceeding the recommended intake of calories (2200 for men, 1800 for women) "
                        + "\n- 59% of Singaporeans exceed the recommended intake in 2010, as the average calorie intake was 2,624 in 2010.");
                break;
            default:
                break;
        }
        return output;
    } //end of getOutput Method

    //when user inputs emergency in BotV2 class
    public static String location(String locationString) {
        String output = "";
        switch (locationString.toLowerCase()) {
            case "north":
                output += ("The nearest general hospitals around you are:"
                        + "\n 1. Khoo Teck Puat Hospital(Government, 90 Yishun Central) - Take bus 103 or 805 from Yishun Bus Interchange and alight opposite of KTPH."
                        + "\n 2. Sengkang General Hospital(Government, 1 Anchorvale Street) - this 1000-bed hospital will be open by 2018, located near Sengkang Station on the North-East Line");

                break;
            case "south":
                output += ("The nearest general hospitals around you are:"
                        + "\n 1. National University Hospital(Government, 5 Lower Kent Ridge Road) - Take the Circle Line to Kent Ridge Station, NUH is located at Kent Ridge Station's doorstep."
                        + "\n 2. Singapore General Hospital(Government, Outram Road) - Take East-West line or North-East line to Outram Park Station, shuttle bus is provided to SGH at Outram Park Station");
                break;
            case "west":
                output += ("The nearest general hospitals around you are:"
                        + "\n 1. Ng Teng Fong General Hospital(Government, 1 Jurong East Street 21) - Take the North-South Line to Jurong East, and walk 250m (3 mins) to Ng Teng Fong.");
                break;
            case "east":
                output += ("The nearest general hospitals around you are:"
                        + "\n 1. Changi General Hospital(Government, 2 Simei Street 3) - Take the East-West Line to Simei, shuttle bus in provided from 8.30am to 9.30pm (weekdays) and 8.30am to 3.00pm (on Saturday)."
                        + "\n 2. Parkway East Hospital(Private, 321 Joo Chiat Place) - The following buses goes to PEH: 15,33,150 and 155. You can also take the East-West line to Eunos, and take bus 15 to PEH.");

                break;
            case "central":
                output += ("The nearest general hospitals around you are:"
                        + "\n 1. KK Women's And Children's Hospital(Government, 100 Bukit Timah Road) - Shuttle bus is provided at both Novena Station on the North-South Line, and Bugis Station on the East-West Line. "
                        + "Alternatively, public buses services numbers 48, 66, 67, 170, 960 also travel to KKH via Kampong Java Road."
                        + "\n 2. Tan Tock Seng Hospital(Government, 11 Jalan Tan Tock Seng) - Tan Tock Seng Hospital is located behind of Novena Mrt on the North-South Line."
                        + "\n 3. Gleneagles Hospital(Private, 6A Napier Road) - Bus services numbers 7, 77, 105, 106, 174 go to Gleneagles Hospital from Orchard Station on North-South Line."
                        + "\n 4. Mount Alvernia Hospital(Private, 820 Thomson Road) - Shuttle bus services are provided from Bishan Station on North-South Line(6.35am - 8.15pm, 20-minute intervals)"
                        + " and Novena Station on North-South Line(8.00am - 7.30pm, 30-minute intervals)");
            default:
                output += "Invalid location please re-enter";
                break;

        }
        return output;
    } //end of location method
} //end of class 
