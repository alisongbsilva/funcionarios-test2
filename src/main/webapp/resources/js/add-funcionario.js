// Adiciona os setores ao select do formulário
function selectSetores(conteudo) {
  let select = document.getElementById("setorid");

  conteudo.map((i) => {
    let id = i.idsetor;
    let nome = i.nomesetor;
    let option = document.createElement("option");
    option.value = id;
    option.innerHTML = nome;
    select.appendChild(option);
  });
}

// Recupera dados de funcionarios e chama o contrutor da tabela
function listarSetores() {
  let URL_TO_FETCH = "http://localhost:8080/funcionarios-test2/rs/setor";
  let lista = [];

  fetch(URL_TO_FETCH, {
  method: "GET",
  mode: "same-origin"
  })
  .then(response => response.json()) // retorna uma promise
  .then(result => {
  lista = result;
  this.selectSetores(lista);
  })
  .catch(err => {
  // trata se alguma das promises falhar
  console.error('Erro ao listar setores!', err);
  });
}
window.onload = listarSetores();



// Requisição de cadastro de funcionário
function cadastrarFuncionario (body) {
    const options = {
      method: 'POST',
      body: body,
      headers: {
        'Content-Type': 'application/json'
      }
    }

    return fetch('http://localhost:8080/funcionarios-test2/rs/funcionario/', options)
      .then(T => T.json())
}

// Pega os dados do formulário e chama a requisição
function addFuncionario() {
    let dados = Array.from(document.querySelectorAll('#funcionario-form select, #funcionario-form input')).reduce((acc, input) => ({ ...acc, [input.id]: input.value}), {});
    this.cadastrarFuncionario(JSON.stringify(dados))
    .then(() => {
      alert("Funcionário cadastrado com sucesso!");
       document.location.href = "../index.html"}) 
    .catch(() => console.log('falha ao cadastrar'));
}

// Carrega os dados para edição
function carregarDados() {
  //let id = String(window.location.search);
  const queryString = window.location.search;
  const urlParams = new URLSearchParams(queryString);
  let id = urlParams.get("id");
  let url = "http://localhost:8080/funcionarios-test2/rs/funcionario/" + id;

  fetch(url, {
    method: "GET",
    mode: "same-origin"
  })
  .then(response => response.json())
  .then(result => {
      funcionario = result;
      let idfuncionario = document.getElementById("idfuncionario");
      let nome = document.getElementById("nomefuncionario");
      let salario = document.getElementById("salario");
      let email = document.getElementById("email");
      let idade = document.getElementById("idade");
      let setorid = document.getElementById("setorid");
      idfuncionario.value = id;
      nome.value = funcionario.nomefuncionario;
      salario.value = funcionario.salario;
      email.value = funcionario.email;
      idade.value = funcionario.idade;
      setorid.value = funcionario.setorid;

  })
  .catch(err => {
    console.error('Erro ao carregar dados do funcionário');
  })

}

// Altera propriedades da página para edição
if(window.location.search != "") {
  window.onload = carregarDados();

  let titulo = document.getElementById("op");
  titulo.innerHTML = "Alteração";

  let btnSubmit = document.getElementById("btnSubmit");
  btnSubmit.innerHTML = "Atualizar";
  let id = document.getElementById("idfuncionario");
  btnSubmit.setAttribute("onclick", "altFuncionario()");
}

// Requisição de edição de funcionário
function alterarFuncionario (body, idEdit) {
  let idSend = idEdit;
  let url = 'http://localhost:8080/funcionarios-test2/rs/funcionario/' + String(idEdit);
  const options = {
    method: 'PUT',
    body: body,
    headers: {
      'Content-Type': 'application/json'
    }
  }

  return fetch(url, options)
    .then(T => T.json())
}

// Pega os dados do formulário e chama a requisição
function altFuncionario() {
  let idEdit = document.getElementById("idfuncionario").value;
  let dados = Array.from(document.querySelectorAll('#funcionario-form select, #funcionario-form input')).reduce((acc, input) => ({ ...acc, [input.id]: input.value}), {});
    this.alterarFuncionario(JSON.stringify(dados), idEdit)
    .then(() => {
      alert("Funcionário atualizado com sucesso!");
      document.location.href = "../index.html"})
    .catch(() => console.log('falha ao atualizar dados do funcionário!'));
}

