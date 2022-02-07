class BigNumber {
  private int number[];
  private int size;

  BigNumber (String n) {    // Construtor com base no tamanho da string passada
    size = n.length();
    number = new int[size];
    int i = 0, j = size-1;
    while (j>=0) {                      // Armazena os valores de trás para a frente, i.e.,
      number[j--] = n.charAt(i++);      // "1234" fica armazendo como 4321
    }
  }

  public boolean equals (BigNumber n) {   // Verifica se dois números são iguais
    int i = 0;
    if (size != n.size) return false;     // Comparando o tamanho
    while (i<size)
    if (number[i]!=n.number[i++]) return false;   // Comparando carater a carater
    return true;                                    // se tiverem o mesmo tamanho
  }

  public String toString() {    // O modo como dever ser "printada" a string,
  String res = "";            // começando do fim para o início devido à
  int i = size-1;             // maneira como foi armazenada
  while (i>=0) res += (number[i--]-'0');
  return res;
}

public BigNumber add (BigNumber n) {
  String res = "";            // String temporária
  String resultfinal = "";    // String Final
  int maxsize, minsize, a, b, acum = 0;  // Tamanho do maior n, menor n
  if (size>=n.size) {           // Verificar qual tem maior tamanho
    maxsize = size;
    minsize = n.size;
  } else {
    maxsize = n.size;
    minsize = size;
  }
  for (int i=0 ; i<minsize ; i++) {   // Ciclo para somar cada carater
    a = number[i]-'0';                // até ao último do número mais pequeno
    b = n.number[i]-'0';              // tendo em conta que pode haver
    if ( (a+b+acum)>9 ) {             // acumulação (acum)
      res += (a+b+acum)%10;
      acum = 1;
    } else {
      res += (a+b+acum);
      acum = 0;
    }
  }
  for (int i=minsize ; i<maxsize ; i++) {   // Ciclo para colocar cada carater
    if (minsize==size) a = n.number[i]-'0'; // do número maior, tendo em conta
    else a = number[i]-'0';                 // a acumulação
    if ( (a+acum)>9 ) {
      res += (a+acum)%10;
      acum = 1;
    } else {
      res += (a+acum);
      acum = 0;
    }
  }
  if (acum==1) res += 1;    // Se no final ainda houver acumulação, coloca-se no final
  for (int i=(res.length()-1) ; i>=0 ; i--) {   // Inverter a string para
    resultfinal += res.charAt(i);               // a string final
  }
  BigNumber m = new BigNumber(resultfinal);     // Construção de um BigNumber
  return m;
}


public BigNumber multiply (BigNumber n) {
  String multip = "";
  String multip2 = "";
  int a, b, acum = 0;
  BigNumber r = new BigNumber("");
  for (int j=0 ; j<n.size ; j++) {
    b = n.number[j] - '0';
    for (int i=0 ; i<j ; i++) {
      multip += 0;
    }
    for (int i=0 ; i<size ; i++) {
      a = number[i] - '0';
      multip += ((a*b)+acum)%10;
      acum = ((a*b)+acum)/10;
    }
    if (acum != 0) {
      multip += acum;
      acum = 0;
    }
    for (int i=(multip.length()-1) ; i>=0 ; i--) {
      multip2 += multip.charAt(i);
    }
    BigNumber bnmultip = new BigNumber(multip2);
    r = r.add(bnmultip);
    multip = "";
    multip2 = "";
  }
  return r;
}
}
