/* 
 *  Name: Aquino, Robinx Prhynz Mas
 *  Year: BSCS 1A
 *  Student ID: 202210599
 * 
 */

import java.util.Scanner;

public class casestudy {

    static String[] peripherals = new String[100];
    static String[] inputPeri = new String[100];
    static String[] outputPeri = new String[100];
    static String[] bothPeri = new String[100];
    static String[] empPeri = new String[100];
    static String[] code = new String[100];
    static int codeforArray, constantCode = 20230001, numOfPeriEmp = 0, temp1 = 0, numInput = 0, numOutput = 0,
            numBoth = 0;
    static String pcHardware, nameEmp, password = "42069";

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String choices;
        int loop = 0;

        while (loop == 0) { /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// MENU
            System.out.println("================================================================\n");
            System.out.println(
                    "\n[ADD] - Add Record\n[VIEW] - View Record\n[EDIT] - Edit Record\n[DELETE] - Delete Record\n[REPORT] - Show the total\n[EXIT] - Exit");
            System.out.println("\n\n================================================================");
            choices = in.nextLine().toUpperCase();

            switch (choices) {
                case "ADD":
                    addFunc();
                    break;

                case "VIEW":
                    viewFunc();
                    break;

                case "EDIT":
                    editFunc();
                    break;

                case "DELETE":
                    deleteFunc();
                    break;

                case "REPORT":
                    reportFunc();
                    break;

                case "EXIT":
                    System.out.println("Successfully!");
                    return;

                default:
                    System.out.println("Enter a valid choice! - MENU");

            }
        }
    }

    static void addFunc() { ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// ADD
        Scanner in2 = new Scanner(System.in);
        System.out.println("================================================================\n");
        System.out.println("\n[1] - Add Peripheral\n[2] - Add Peripheral to Employee");
        System.out.println("\n\n================================================================");
        String choices2 = in2.nextLine().toUpperCase();

        if (choices2.equals("1")) {

            System.out.println("================================================================\n");
            System.out.print("\nCode: " + constantCode);
            System.out.print("\nName of PC Hardware: ");
            System.out.println("\n\n\n================================================================");
            pcHardware = in2.nextLine().toUpperCase();
            System.out.println("================================================================\n");
            System.out.println("\nWhere to? \n[1] Input Devices\n[2] Output Devices\n[3] Input/Output Devices");
            System.out.println("\n\n================================================================");
            String choices = in2.nextLine().toUpperCase();

            switch (choices) {

                case "1": // input choice
                    peripherals[numOfPeriEmp] = pcHardware; // putting input hardware into all peripherals
                    inputPeri[numOfPeriEmp] = pcHardware; // putting input hardware into inputPeripherals
                    numInput++;
                    peripherals[numOfPeriEmp] = pcHardware; // applying user input to array peripherals
                    break;

                case "2": // output choice
                    peripherals[numOfPeriEmp] = pcHardware;
                    outputPeri[numOfPeriEmp] = pcHardware;
                    numOutput++;
                    peripherals[numOfPeriEmp] = pcHardware; // applying user input to array peripherals
                    break;

                case "3": // input/output choice
                    peripherals[numOfPeriEmp] = pcHardware;
                    bothPeri[numOfPeriEmp] = pcHardware;
                    numBoth++;
                    peripherals[numOfPeriEmp] = pcHardware; // applying user input to array peripherals
                    break;
                default:
                    System.out.println("Enter a valid choice!");
                    return;
            }
            System.out.println("================================================================\n\n");
            System.out.println("[1] - Assign an employee to the Peripheral?");
            System.out.println("[2] - Do not assign");
            System.out.println("\n\n================================================================");
            String choice1 = in2.nextLine().toUpperCase();
            switch (choice1) {
                case "1":
                    System.out.println("================================================================\n\n");
                    System.out.println("Enter the name of the Employee: ");
                    System.out.println("\n\n================================================================");
                    nameEmp = in2.nextLine().toUpperCase();
                    empPeri[numOfPeriEmp] = nameEmp;
                    break;

                case "2":
                    break;

                default:
                    System.out.println("Enter a valid choice!");

            }
            code[numOfPeriEmp] = String.valueOf(constantCode);
            constantCode++; // starts with 20030001 increment by 1 every add
            numOfPeriEmp++; // index of the array

        }

        else if (choices2.equals("2")) {
            System.out.println("Enter a peripheral that you want to assign an employee: "); // ASSIGNING A NAME TO A
                                                                                            // PERIPHERAL
            String tempPeri = in2.nextLine().toUpperCase();

            for (int temp1 = 0; temp1 < peripherals.length; temp1++) {
                if (peripherals[temp1] != null && peripherals[temp1].equals(tempPeri)) {
                    break;
                } else if (peripherals[temp1] != null && !peripherals[temp1].equals(tempPeri)) {
                    continue;

                } else {
                    System.out.println("Enter the correct peripheral!");
                    return;
                }
            }

            for (int temp1 = 0; temp1 < peripherals.length; temp1++) {
                if (peripherals[temp1] != null && peripherals[temp1].equals(tempPeri)) {
                    if (empPeri[temp1] == null) {
                        System.out.println("================================================================\n");
                        System.out.println("Enter the name of the Employee: ");
                        System.out.println("\n\n================================================================");
                        nameEmp = in2.nextLine().toUpperCase();
                        empPeri[temp1] = nameEmp;
                        break;
                    } else if (empPeri[temp1] != null) {
                        System.out.println("Has already assigned employee in this peripheral!");
                        break;
                    }
                } else if (peripherals[temp1] == null || !peripherals[temp1].equals(tempPeri)) {
                    continue;
                } else {
                    System.out.println("Enter the correct peripheral!");
                    break;
                }

            }

        } else {
            System.out.println("Enter a valid choice! - ADDFUNC");
            addFunc(); // CALLING ADD FUNC TO NOT GO BACK TO MENU
        }

        return;

    }

    private static void reportFunc() { ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// REPORT
        int periCounter = 0, assPeriCounter = 0, inputCounter = 0, outputCounter = 0, bothCounter = 0, empCounter = 0;

        for (int temp1 = 0; temp1 < peripherals.length; temp1++) {
            if (peripherals[temp1] != null && empPeri[temp1] == null) {
                periCounter++;
            } else {
                continue;
            }
        }
        System.out.println("A. Number of available peripherals: " + periCounter);

        for (int temp1 = 0; temp1 < peripherals.length; temp1++) {
            if (peripherals[temp1] != null && empPeri[temp1] != null) {
                assPeriCounter++;
            } else {
                continue;
            }
        }
        System.out.println("B. Number of assigned peripherals: " + assPeriCounter);

        for (int temp1 = 0; temp1 < inputPeri.length; temp1++) {
            if (inputPeri[temp1] != null) {
                inputCounter++;
            } else {
                continue;
            }
        }
        System.out.println("C. Number of input device: " + inputCounter);

        for (int temp1 = 0; temp1 < outputPeri.length; temp1++) {
            if (outputPeri[temp1] != null) {
                outputCounter++;
            } else {
                continue;
            }
        }
        System.out.println("D. Number of output device: " + outputCounter);

        for (int temp1 = 0; temp1 < bothPeri.length; temp1++) {
            if (bothPeri[temp1] != null) {
                bothCounter++;
            } else {
                continue;
            }
        }
        System.out.println("E. Number of input/output device: " + bothCounter);

        for (int temp1 = 0; temp1 < empPeri.length; temp1++) {
            if (empPeri[temp1] != null) {
                empCounter++;
            } else {
                continue;
            }
        }
        System.out.println("G. Numbers of employees with peripherals assigned: " + empCounter);

    }

    private static void deleteFunc() { ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// DELETE
        Scanner in7 = new Scanner(System.in);
        Scanner in77 = new Scanner(System.in);
        System.out.println("================================================================\n");
        System.out.printf("%-10s %10s\n", "Peripheral", "Codes");
        System.out.println("----------------------");
        for (int temp1 = 0; temp1 < peripherals.length; temp1++) {
            if (peripherals[temp1] == null && code[temp1] == null) {
                continue;
            } else if (peripherals[temp1] != null && code[temp1] != null) {
                System.out.printf("%-10s %10s\n", peripherals[temp1], code[temp1]);
            }
        }
        System.out.println("\n\n================================================================");
        System.out.println("Enter the code: ");
        String tempCode1 = in7.nextLine();

        for (int temp1 = 0; temp1 < code.length; temp1++) {
            if (code[temp1] != null && code[temp1].equals(tempCode1)) {
                if (peripherals[temp1] != null && empPeri[temp1] == null) {
                    System.out.println("You have deleted " + peripherals[temp1]);
                    peripherals[temp1] = null;
                    inputPeri[temp1] = null;
                    outputPeri[temp1] = null;
                    bothPeri[temp1] = null;
                    break;
                } else {
                    String choice1;
                    System.out.println("Do you want to remove the assigned employee from the " + peripherals[temp1]);
                    System.out.println("[1] Yes [2] No");
                    choice1 = in77.nextLine();
                    if (choice1.equals("1")) { //////////////////////////////////////////////////////////////////// BRB
                        System.out.println("You have deleted " + empPeri[temp1]);
                        empPeri[temp1] = null;
                        return;

                    } else {
                        System.out.println("Enter a valid choice!");
                        return;
                    }
                }
            } else if (code[temp1] != null && !code[temp1].equals(tempCode1)) {
                continue;
            } else {
                System.out.println("Enter a correct code!");
                break;
            }
        }
    }

    private static void editFunc() { ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// EDIT
        Scanner in5 = new Scanner(System.in);
        Scanner in55 = new Scanner(System.in);
        String editPeri;
        
        System.out.println("================================================================\n");
        System.out.println("Enter a peripheral that you want to edit.");
        System.out.println("\n\n================================================================");
        editPeri = in5.nextLine().toUpperCase();

        for (int temp1 = 0; temp1 < peripherals.length; temp1++) {
            
            if (peripherals[temp1] != null && peripherals[temp1].equals(editPeri)) { ///////////// BUG FIXED!
                if (peripherals[temp1] != null && empPeri[temp1] != null) {
                    System.out.println(
                            "You cannot update this peripheral as it has an assigned employee! You can delete employee at DELETE menu");
                    return;
                }
                System.out.println("================================================================\n");
                System.out.println("Found!"); ///// NEEDS PASSWORD
                System.out.println("Enter the password to proceed: ");
                System.out.println("\n\n================================================================");
                String tempPass = in5.nextLine();

                if (password.equals(tempPass)) {
                    System.out.println("================================================================\n");
                    System.out.println("Enter or Edit your peripheral");
                    System.out.println("\n\n================================================================");
                    String newPeri = in55.nextLine().toUpperCase();
                    System.out.println("================================================================\n");
                    System.out.println("Are you sure about this?");

                    System.out.println("[1] Yes\n[2] No");
                    System.out.println("\n\n================================================================");
                    int choiceSure = in5.nextInt();

                    if (choiceSure == 1) {
                        if (peripherals[temp1] == inputPeri[temp1]) {
                            peripherals[temp1] = newPeri;
                            inputPeri[temp1] = newPeri;
                        }

                        else if (peripherals[temp1] == outputPeri[temp1]) {
                            peripherals[temp1] = newPeri;
                            outputPeri[temp1] = newPeri;
                        } else if (peripherals[temp1] == bothPeri[temp1]) {
                            peripherals[temp1] = newPeri;
                            bothPeri[temp1] = newPeri;
                        }

                        System.out.println("Changed Successfully!");
                        break;
                    } else {
                        break;
                    }
                } else {
                    System.out.println("Enter the correct password!");
                    break;
                }

            } else if (peripherals[temp1] != null && !peripherals[temp1].equals(editPeri)) {
                continue;
            } else if (temp1 == peripherals.length - 1) {
                System.out.println("Enter the correct peripheral!");
                break;// DONT FORGET TO BREAK OR IT WILL HAVE MANY PRINTS
            } else {
                continue;

            }
        }
    }

    private static void viewFunc() { /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// VIEW
        Scanner in6 = new Scanner(System.in);
        System.out.println("================================================================\n");
        System.out.println("[1] Peripheral Record - Specific peripheral record showing all its attributes values");
        System.out.println("[2] Available Peripherals - Show all peripherals that were not assigned yet.");
        System.out.println("[3] Assigned Peripherals - Show all peripherals that were assigned.");
        System.out.println("[4] Input Devices - Show all peripherals that is under input devices.");
        System.out.println("[5] Output Devices - Show all peripherals that is under output devices.");
        System.out.println("[6] Input/Output Devices - Show all peripherals that is under input/output devices.");
        System.out.println("[7] View all employees");
        System.out.println("\n\n================================================================");
        String choiceFunc = in6.nextLine().toUpperCase();

        switch (choiceFunc) {
            case "1": // PERIPHERAL RECORD
                System.out.println("Peripheral Record: \n");
                System.out.printf("%-15s %15s %15s %25s\n", "Peripheral", "Codes", "Type", "Employee");
                System.out.println("--------------------------------------------------------------------------");
                for (int temp1 = 0; temp1 < peripherals.length; temp1++) {

                    if (peripherals[temp1] != null) {
                        if (peripherals[temp1] != null && peripherals[temp1].equals(inputPeri[temp1])) {
                            if (empPeri[temp1] != null) {
                                System.out.printf("%-15s %15s %15s %25s\n", peripherals[temp1], code[temp1], "Input",
                                        empPeri[temp1]);

                            } else {
                                System.out.printf("%-15s %15s %15s %25s\n", peripherals[temp1], code[temp1], "Input",
                                        "None");

                            }
                        } else if (peripherals[temp1] != null && peripherals[temp1].equals(outputPeri[temp1])) {
                            if (empPeri[temp1] != null) {
                                System.out.printf("%-15s %15s %15s %25s\n", peripherals[temp1], code[temp1], "Output",
                                        empPeri[temp1]);

                            } else {
                                System.out.printf("%-15s %15s %15s %25s\n", peripherals[temp1], code[temp1], "Output",
                                        "None");

                            }
                        } else if (peripherals[temp1] != null && peripherals[temp1].equals(bothPeri[temp1])) {
                            if (empPeri[temp1] != null) {
                                System.out.printf("%-15s %15s %15s %25s\n", peripherals[temp1], code[temp1],
                                        "Input/Output",
                                        empPeri[temp1]);

                            } else {
                                System.out.printf("%-15s %15s %15s %25s\n", peripherals[temp1], code[temp1],
                                        "Input/Output",
                                        "None");

                            }
                        } else {

                        }
                    }
                }
                break;
            case "2": // AVAILABLE PERIPHERALS
                System.out.println("Available Peripherals: ");
                for (int temp1 = 0; temp1 < peripherals.length; temp1++) {
                    if (empPeri[temp1] == null && peripherals[temp1] != null) {
                        System.out.println(peripherals[temp1]);

                    } else {
                        continue;
                    }
                }
                break;
            case "3": // ASSIGNED PERIPHERALS
                System.out.println("Assigned Peripherals: ");

                for (int temp1 = 0; temp1 < peripherals.length; temp1++) {
                    if (empPeri[temp1] != null && peripherals[temp1] != null) {
                        System.out.println(peripherals[temp1]);

                    } else {
                        continue;
                    }
                }
                break;
            case "4": // INPUT RECORD
                System.out.println("Input Peripherals: ");
                for (int temp1 = 0; temp1 < inputPeri.length; temp1++) {
                    if (inputPeri[temp1] == null) {
                        continue;
                    } else {
                        System.out.println(inputPeri[temp1]);
                    }

                }
                break;
            case "5": // OUTPUT PERIPHERAL
                System.out.println("Output Peripherals: ");
                for (int temp1 = 0; temp1 < outputPeri.length; temp1++) {
                    if (outputPeri[temp1] == null) {
                        continue;
                    } else {
                        System.out.println(outputPeri[temp1]);
                    }

                }
                break;
            case "6": // BOTH PERIPHERAL
                System.out.println("Input & Output Peripherals: ");
                for (int temp1 = 0; temp1 < bothPeri.length; temp1++) {
                    if (bothPeri[temp1] == null) {
                        continue;
                    } else {
                        System.out.println(bothPeri[temp1]);
                    }

                }
                break;
            case "7":
                System.out.println("Employees: ");
                for (int temp1 = 0; temp1 < empPeri.length; temp1++) {
                    if (empPeri[temp1] == null) {
                        continue;
                    } else {
                        System.out.println(empPeri[temp1]);
                    }

                }
                break;

            default:
                System.out.println("Enter a valid choice!");
                viewFunc();
        }
    }

}
