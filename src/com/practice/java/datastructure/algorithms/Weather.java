package com.practice.java.datastructure.algorithms;

import java.util.*;                          // for Scanner class

public class Weather {
    // main
    public static void main(String args[]) throws java.io.FileNotFoundException {

        boolean  done;                  // exit test flag
        boolean goodFilename;           // flag for valid filename input
        boolean goodCutoff;             // humidity cutoff value
        String selection;               // menu selection
        Scanner console;                // Java console Scanner
        console = new Scanner(System.in);
        String filename;                // data file name
        java.io.File datafile;          // file

        // Initialize exit flag
        done = false;

        while (!done) {
            // Output menu list
            System.out.print(" ");
            System.out.print("  Weather Station: \n");      
            System.out.print("  1) Load Data\n");       
            System.out.print("  2) Exit Program\n\n");              

            // Input data                   
            System.out.print("Menu selection -> ");     
            selection = console.next();
            System.out.print("\n");

            // Process input
            if (selection.equals("1")) {
                do {
                    goodFilename = true;    // assume good filename
                    System.out.print("Enter filename: ");
                    filename = console.next();
                    datafile = new java.io.File(filename);
                    // check if file currently exists
                    if (!datafile.canRead()) {
                        System.out.println("** Invalid File. Try again. **");
                        goodFilename = false;
                    }
                } while (!goodFilename);

                // create input file
                java.util.Scanner   fileInput;  // Java console Scanner
                fileInput= new java.util.Scanner(datafile);         

                // Read Peak Wind Speed data into array
                int[] peakwindspeed;
                peakwindspeed = new int[288];
                String dataLine;
                int count=0;

                //Read Temperature data into array
                int[] temperature;
                temperature = new int[288];
                String dataLine2;
                int count2=0;

                //Enter cutoff value for humidity

                int number = 0;

                goodCutoff = false;
                while (goodCutoff==false) {
                    System.out.print("Please enter humidity cutoff value: ");   

                    selection = console.next(); 

                    System.out.print("\n");

                    int sum = 0;
                    int numbers [] = new int[288];

                    if (selection.equals(number <= 100)) { //THIS IS WHAT YOU NEED TO LOOK AT
                        double average = sum / numbers.length;
                        goodCutoff = true;
                        }
                    else {
                        System.out.println("Please enter a value between 1 - 100");
                    }
                }
                //Read Humidity & Temperature
                int[] humidity;
                humidity = new int[288];
                String dataLine3;
                int count3=0;

                //Read Heating Degree Day
                int[] hdd, averagetemp, basetemp;
                hdd = new int[288];
                String dataLine4;
                int count4=0;

                if (fileInput.hasNextLine()) {
                    // check data file header
                    if (fileInput.nextLine().equals("Temp Hi Low Out Dew Wind Wind Wind Hi Hi Wind Heat THW THSW Rain  Solar Solar Hi Solar UV UV Hi Heat Cool In In In In Wind Wind ISS Arc. Date  Time Out Temp Temp Hum Pt. Speed Dir Run Speed Dir Chill Index Index Index Bar Rain Rate Rad. Energy Rad. Index Dose UV D-D D-D Temp Hum Dew Heat ET Samp Tx Recept Int.")) {
                        // read data
                        while (fileInput.hasNextLine()) {
                            // process line
                            dataLine = fileInput.nextLine();
                            // ignore first six lines
                            for (int i=0; i<6; i++) {
                                dataLine = dataLine.substring(dataLine.indexOf(',')+1);
                            }
                            // save peak wind speed info
                            dataLine = dataLine.substring(0,dataLine.indexOf(','));
                            peakwindspeed[count] = Integer.parseInt(dataLine);
                            count++;

                            dataLine2 = fileInput.nextLine();
                            for (int i=0; i<6; i++) {
                                dataLine2 = dataLine2.substring(dataLine2.indexOf(',')+1);
                            }
                            // save temperature info
                            dataLine2 = dataLine2.substring(0,dataLine2.indexOf(','));
                            temperature[count] = Integer.parseInt(dataLine2);
                            count++;


                            dataLine3 = fileInput.nextLine();
                            for (int i=0; i<6; i++) {
                                dataLine3 = dataLine3.substring(dataLine3.indexOf(',')+1);
                            }
                            // save temperature & humidity info
                            dataLine3 = dataLine3.substring(0,dataLine3.indexOf(','));
                            humidity[count] = Integer.parseInt(dataLine3);
                            count++;

                            dataLine4 = fileInput.nextLine();
                            for (int i=0; i<6; i++) {
                                dataLine4 = dataLine4.substring(dataLine4.indexOf(',')+1);
                            }
                            // save hdd info
                            dataLine4 = dataLine4.substring(0,dataLine4.indexOf(','));
                            hdd[count] = Integer.parseInt(dataLine4);
                            count++;

                        }
                    } else {
                        System.out.println("Invalid File");
                    }
                }else {
                    System.out.println("File Empty");
            }
            //Reports Peak Wind Speed   
            int max;
            max = peakwindspeed[0];
            for (int i=1; i<count; i++) {
                if (peakwindspeed[i]>max) {
                    max = peakwindspeed[i];
                }
            }

            System.out.println("Peak Wind Speed = " + max);

            //Reports Maximum Temperature
            int maxtemp, maxdate;
            maxtemp = temperature[0];
            maxdate = 1;
            for (int i=1; i<count2; i++) {
                if (temperature[i]>maxtemp) {
                    maxtemp = temperature[i];
                    maxdate = i+1;
                }
            }

            System.out.println("Max Temp = " + maxtemp);
            System.out.println("Date = " + maxdate);

            //Reports temp & humidity

            int maxhumidity;
            maxhumidity = humidity[0];
            for (int i=1; i<count3; i++) {
                if (humidity[i]>maxhumidity) {
                    maxhumidity = humidity[i];
                }
            }

            System.out.println("Max Humidity = " + maxhumidity);

            //Reports Heating Degree Day

            int maxhdd, average=0, base=0, heatdd;
            maxhdd = hdd[0];
            heatdd = base - average;
            for (int i=1; i<count4; i++) {
                if (hdd[i]>maxhdd) {
                    maxhdd = hdd[i];
                }
            }

            System.out.println("Heating Degree Day:" + heatdd);


            //Option 2 for exiting program
            } else if (selection.equals("2")) {
                System.out.println("Goodbye.");
                done = true;                    
            } else {
                System.out.println("** Invalid Selection. **");
            }
        } // end of while loop      
    } // end of main
} // end of class