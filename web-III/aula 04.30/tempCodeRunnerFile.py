cursor.execute('''create table aluno(
    matricula int primary key auto_increment,
    nome varchar(30) not null,
    idade int(3),
    email varchar(50))''')