int tab[5];

void triSelection(int n)
{
	int i = 0;
	int j = 0;
	int min;
	int tmp;
	for(i=0; i<n-1; i=i+1)
	{
		min = i;
		for(j=i+1;j<n;j=j+1)
		{
			if(tab[j] < tab[min])
				min = j;
		}
		if(min != i)
		{
			tmp = tab[i];
			tab[i] = tab[min];
			tab[min] = tmp;
		}
	}
}

int pgcd(int a, int b)
{
	int r;
	affichePGCD(a,b);
	if(a==0){
		r=b;
	}
	else{
		if(b==0){
			r=a;
		}
		else{
			if(b<=a){
				a=a-b;
				r=pgcd(a,b);
			}
			else{
				b=b-a;
				r=pgcd(a,b);
			}
		}
	}
	return r;
}

void affichePGCD(int x, int y)
{
	char s6[6] = {'p','g','c','d','(','\0'};
	print(s6);
	printi(x);
	printc(',');
	printi(y);
	printc(')');
	printc('\n');
}

void afficheTABLEAU(){
	int i;
	for(i=0;i<5;i=i+1)
	{
		printi(tab[i]);
	}
	printc('\n');
	printc('\n');
}

void main()
{
	// chaines pour l'affichage
	char s1[5] = {'t', 'a', 'b', '(','\0'};
	char s1f[3] = {')', '=','\0'};
	char s2[11] = {'n', 'o', 'n', ' ', 't', 'r', 'i', 'e', ':', '\n', '\0'};
	char s3[7] = {'t', 'r', 'i', 'e', ':', '\n', '\0'};
	char s4[8] = {'d', 'a', 'n', 's', ' ', 'i', 'f', '\0'};
	char s5[10] = {'d', 'a', 'n', 's', ' ', 'e', 'l', 's', 'e', '\0'};

	//  tableaux de même taille
	int tab1[5] = {18, 8, 24, 36, 7};
	int tab2[5] = {3, 2, 6, 120, 6};
	// petite addition qui prend plus de 10 registres
	tab2[2] = (1+(2+(3+(4+(5+(6+(7+(8+(9+(10+(11+12)))))))))));
	
	// un nombre et 2 pointeurs
	int nb = 42;
	int * p1 = &nb;
	int ** p2 = &p1;

	// on fait le pgcd sur les 2 tableaux
	int i;
	for(i=0; i<5; i=i+1)
	{
		tab[i] = pgcd(tab1[i],tab2[i]);
		print(s1);
		printi(i);
		print(s1f);
		printi(tab[i]);
		printc('\n');
		printc('\n');
	}
	
	// on affiche les pgcd pas triés
	print(s2);
	afficheTABLEAU();
	
	// on trie les pgcd (tri sélection)
	triSelection(5);
	
	// on affiche les pgcd triés
	print(s3);
	afficheTABLEAU();
	
	// test avec evaluation paresseuse
	if(1!=1 && 1==1)
	{
		print(s4);
	}
	else
	{
		print(s5);
	}
	printc('\n');
	printi(**p2);
}