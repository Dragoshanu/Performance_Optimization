class LazyNumberDetails {

    private int number;

    private int primeCache;
    private boolean primeNumber;
    private int prefectCache;
    private boolean perfectNumber;
    private int magicCache;
    private boolean magicNumber;

    public LazyNumberDetails(int number) {
        this.number = number;

        this.primeNumber = false;
        this.perfectNumber = false;
        this.magicNumber = false;

        this.primeCache = -1;
        this.prefectCache = -1;
        this.magicCache = -1;

    }

    public boolean isPrime() {
        if (primeCache != this.number) {
            primeCache = this.number;
            System.out.println("Evaluating isPrime(" + this.number + ")");
            for (int i = 2; i * i <= number; i++) {
                if (this.number % i == 0) {
                    this.primeNumber = false;
                    return false;
                }
            }
            this.primeNumber = true;
            return true;
        } else {
            System.out.println("Using cached value for isPrime(" + this.number + ")");
            return this.primeNumber;
        }
    }

    public boolean isPerfect() {

        int sumDivisors = 1;
        if (prefectCache != this.number) {
            prefectCache = this.number;
            System.out.println("Evaluating isPerfect(" + this.number + ")");
            for (int i = 2; i <= number / 2; i++) {
                if (this.number % i == 0) {
                    sumDivisors += i;
                }
            }
            if (sumDivisors == this.number) {
                this.perfectNumber = true;
                return true;
            }
            this.perfectNumber = false;
            return false;
        } else {
            System.out.println("Using cached value for isPerfect(" + this.number + ")");
        }
        return this.perfectNumber;
    }

    public boolean isMagic() {
        if (magicCache != this.number) {
            magicCache = this.number;
            System.out.println("Evaluating isMagic(" + this.number + ")");
            int copy = this.number;
            while (copy >= 10) {
                copy = sumDigit(copy);
            }
            this.magicNumber = (copy == 3 || copy == 7 || copy == 9);
        } else {
            System.out.println("Using cached value for isMagic(" + this.number + ")");
        }
        return this.magicNumber;
    }


    private int sumDigit(int number) {
        int sum = 0;
        while(number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public void updateNumber (int number){
        this.number = number;

        if (number != this.number) {
            this.primeNumber = false;
            this.perfectNumber = false;
            this.magicNumber = false;

            this.primeCache = -1;
            this.prefectCache = -1;
            this.magicCache = -1;
        }
    }
}