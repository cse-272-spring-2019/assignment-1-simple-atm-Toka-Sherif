package sample;

public class logicwindow {

    int amount;
    int newbalance;
    initialization windowvalid = new initialization();


    public void getbalance(int balance)
    {
        this.newbalance= balance;
    }


    public void saveTransactions(int amount)
    {
        System.out.println("succssesTransaction");
        GlobaleVariables.arrBalnces[GlobaleVariables.i]=amount ;
        GlobaleVariables.i++;
        // return arrBalances;
        // public void getTransaction()

    }


    public int getCurrentBalance()
    {

        //System.out.println("The current balance is " + this.newbalance);
        return this.newbalance;
    }
    public  int withdraw (int amount)
    {
        System.out.println("The balance to be withdrawn"+amount);
        if(amount<this.newbalance)
        {
            this.newbalance = this.newbalance - amount ;
            return this.newbalance;
        }
        else
        {
            System.out.println("ERORR......The amount isn't found");
            return 0;
        }

    }

    public int deposit (int amount)
    {
        this.newbalance = this.newbalance + amount;
        saveTransactions(this.newbalance);
        return this.newbalance;
    }

    public int nextTransaction()
    {
        GlobaleVariables.i++;
        GlobaleVariables.i++;
        System.out.println("next");
        return GlobaleVariables.arrBalnces[GlobaleVariables.i];
    }

    public int prevTransaction ()
    {
        GlobaleVariables.i--;
        GlobaleVariables.i--;
        System.out.println("Previous");
        return  GlobaleVariables.arrBalnces[GlobaleVariables.i];


    }
    public boolean validate (int cardNumber) {
        boolean result = false;
        int[] Cards = windowvalid.getArrCards();
        int i;
        for (i = 0; i < 5; i++)
        {
            if (cardNumber == Cards[i]) {
                result = true;
                break;
            }
        }
        return result;
    }
}


