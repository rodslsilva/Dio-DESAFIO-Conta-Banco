class Conta {
private String titular;
private double saldo;

public Conta(String titular, double saldoInicial) {
    this.titular = titular;
    this.saldo = saldoInicial;
}

public void depositar(double valor) {
    if (valor > 0) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
    } else {
        System.out.println("Valor de depósito inválido.");
    }
}

public void sacar(double valor) {
    if (valor > 0 && saldo >= valor) {
        saldo -= valor;
        System.out.println("Saque de R$" + valor + " realizado com sucesso.");
    } else {
        System.out.println("Saldo insuficiente ou valor inválido.");
    }
}

public void transferir(double valor, Conta destino) {
    if (valor > 0 && saldo >= valor) {
        this.sacar(valor);
        destino.depositar(valor);
        System.out.println("Transferência de R$" + valor + " realizada com sucesso para " + destino.getTitular());
    } else {
        System.out.println("Saldo insuficiente ou valor inválido para transferência.");
    }
}

public double getSaldo() {
    return saldo;
}

public String getTitular() {
    return titular;
}
}

class ContaCorrente extends Conta {
    public ContaCorrente(String titular, double saldoInicial) {
        super(titular, saldoInicial);
    }
}

class ContaPoupanca extends Conta {
    public ContaPoupanca(String titular, double saldoInicial) {
        super(titular, saldoInicial);
    }
}

public class Banco {
    public static void main(String[] args) {
        ContaCorrente cc = new ContaCorrente("João", 1000);
        ContaPoupanca cp = new ContaPoupanca("Maria", 500);

        cc.depositar(200);
        cc.sacar(150);
        cc.transferir(300, cp);

        System.out.println("Saldo João: R$" + cc.getSaldo());
        System.out.println("Saldo Maria: R$" + cp.getSaldo());
    }
}
