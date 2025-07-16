public class Employee{
    private String name, surName;
    private int maas, haftalikSaat;
    private String baslangicYili;
    

    public Employee(String name, String surName, int maas, int haftalikSaat, String baslangicYili) {
        this.name = name;
        this.surName = surName;
        this.maas = maas;
        this.haftalikSaat = haftalikSaat;
        this.baslangicYili = baslangicYili;
    }

    public void run(){
        System.out.println("Çalışan: " + name + " " + surName );
        System.out.println("Calisma saati: " + haftalikSaat);
        System.out.println("Ise Baslama Yili: " + baslangicYili);
        tax();
        bonus();
        raiseSalary();
        toString();
        
        System.out.println("===================================");
    }

    public void tax(){
        if(maas <1000){
            System.out.println("Vergi yok. Maas: " + maas);            
        }else{
            double tax = maas * 0.03;
            maas -= tax;
            System.out.println("Vergi: " + tax + ", Maas: " + maas);
        }
    }
    public void bonus(){
        if(haftalikSaat > 40){
            double bonus = (haftalikSaat - 40) * 30;
            System.out.println("Bonus: " + bonus);
            maas += bonus;
        }else{
            System.out.println("Bonus yok. Maas: " + maas);
        }
    }
    public void raiseSalary(){
        int calisilanYil = 2021 - Integer.parseInt(baslangicYili);
        if(calisilanYil <10 ){
            double zam = maas * 0.05;
            System.out.println("Zam: " + zam + ", Maas: " + (maas + zam));
        } else if(calisilanYil >= 10 && calisilanYil < 20){
            double zam = maas * 0.10;
            System.out.println("Zam: " + zam + ", Maas: " + (maas + zam));
        } else {
            double zam = maas * 0.15;
            System.out.println("Zam: " + zam + ", Maas: " + (maas + zam));
        }
    }
    @Override
    public String toString(){
        return "Employee{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", maas=" + maas +
                ", haftalikSaat=" + haftalikSaat +
                ", baslangicYili='" + baslangicYili + '\'' +
                '}';
    }
    
}