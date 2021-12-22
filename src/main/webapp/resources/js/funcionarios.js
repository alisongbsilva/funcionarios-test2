// Buscar
function buscar(conteudo) {
  let buscaValue = document.getElementById("busca").value;
  let buscaFilter = document.getElementById("busca-filter").value;
  let buscaFuncionario = [];

  if(buscaValue != "") {
    switch (buscaFilter) {
      case "nome":
        buscaFuncionario.push(conteudo.find(i=>i.nomefuncionario.match(buscaValue)));
        return buscaFuncionario;
        break;
      case "setor":
        buscaFuncionario.push(conteudo.find(i=>i.nomesetor.match(buscaValue))); 
        return buscaFuncionario;
        break;
      default:
        return conteudo;
    }
  } else {
    return conteudo;
  }

}

 // Adiciona os funcionários a tabela
 function addFuncionarios(conteudo) {

      let funcionarios = this.buscar(conteudo);
      tbody = document.getElementById("tbody");

    funcionarios.map((i) => {
      let id = i.idfuncionario;
      let nome = i.nomefuncionario;
      let setor = i.nomesetor;
      let btnEditar = document.createElement("button");
      btnEditar.classList.add("btn", "btn-secondary");
      let btnRemover = document.createElement("button");
      btnRemover.classList.add("btn", "btn-danger", "start-5");
      let tr = document.createElement("tr");
      let tdId = document.createElement("td");
      let tdNome = document.createElement("td");
      let tdSetor = document.createElement("td");
      let tdEditar = document.createElement("td");
      let tdRemover = document.createElement("td");
      tr.classList.add("gap-3");
      tdId.classList.add("p-2");
      tdNome.classList.add("p-2");
      tdSetor.classList.add("p-2");
      tdEditar.classList.add("p-2");
      tdRemover.classList.add("p-2");
      tdId.innerHTML = id;
      tdNome.innerHTML = nome;
      tdSetor.innerHTML = setor;
      btnEditar.innerHTML = "<i class='bi bi-pencil-square'></i>";
      btnEditar.onclick = function() {window.location.href = "pages/add-funcionario.html?id=" + id};
      tdEditar.appendChild(btnEditar);
      btnRemover.innerHTML = "<i class='bi bi-x-square-fill'></i>";
      btnRemover.onclick = function() {removerFuncionario(id)};
      tdRemover.appendChild(btnRemover);
      tr.appendChild(tdId);
      tr.appendChild(tdNome);
      tr.appendChild(tdSetor);
      tr.appendChild(tdEditar);
      tr.appendChild(tdRemover);
      tbody.appendChild(tr);
    });
}

// Construtor tabela de funcionarios
function criarTabela() {
    let tabela = document.createElement("table");
    let thead = document.createElement("thead");
    let tbody = document.createElement("tbody");
    tbody.setAttribute("id", "tbody");
    let thd=function(i){return (i==0)?"th":"td";};
  
    let tr = document.createElement("tr");
    tr.classList.add("gap-3");
    let thHeadId = document.createElement("th");
    thHeadId.innerHTML = "Id";
    thHeadId.classList.add("p-2");
    let thHeadNome = document.createElement("th");
    thHeadNome.innerHTML = "Nome";
    thHeadNome.classList.add("p-2");
    let thHeadSetor = document.createElement("th");
    thHeadSetor.innerHTML = "Setor";
    thHeadSetor.classList.add("p-2");
    let thHeadEditar = document.createElement("th");
    thHeadEditar.innerHTML = "Editar";
    thHeadEditar.classList.add("p-2");
    let thHeadRemover = document.createElement("th");
    thHeadRemover.innerHTML = "Remover";
    thHeadRemover.classList.add("p-2");
    tr.appendChild(thHeadId);
    tr.appendChild(thHeadNome);
    tr.appendChild(thHeadSetor);
    tr.appendChild(thHeadEditar);
    tr.appendChild(thHeadRemover);
    thead.appendChild(tr);
    tabela.appendChild(thead);
  
    tabela.appendChild(tbody);
    document.getElementById("lista-funcionarios").appendChild(tabela);
  }

//tela de confirmação de remoção de funcionario
  function removerFuncionario(id){
    let confirmAction = confirm("Tem certeza que deseja remover este funcionário?");
          if (confirmAction) {
            this.rmFuncionario(id);
          } else {

          }
}

//Remove um Funcionario
  function rmFuncionario(id) {
    let URL_TO_FETCH = "http://localhost:8080/funcionarios-test2/rs/funcionario/";

    fetch(URL_TO_FETCH + id, {
    method: "DELETE",
    mode: "same-origin"
    })
    .then(response => response.text()) // retorna uma promise
    .then(result => {
    document.location.reload(true);
    alert(result);
    })
    .catch(err => {
    // trata se alguma das promises falhar
    console.error('Erro ao excluir funcionário!', err);
  });
}



// Recupera dados de funcionarios e chama o contrutor da tabela
function listarFuncionarios() {
    let URL_TO_FETCH = "http://localhost:8080/funcionarios-test2/rs/funcionario";
    let lista = [];

    fetch(URL_TO_FETCH, {
    method: "GET",
    mode: "same-origin"
    })
    .then(response => response.json()) // retorna uma promise
    .then(result => {
    lista = result;

    let divTabela = document.getElementById("lista-funcionarios");
    let tabela = divTabela.firstElementChild;
    if (tabela == null) {
      this.criarTabela();
    }

    let tbodyDados = document.getElementById("tbody");
    let dadosTabela = tbodyDados.firstElementChild;
    if(dadosTabela != null) {
      while (dadosTabela != null) {
        dadosTabela.remove();
        dadosTabela = tbodyDados.firstElementChild;
      }
      
    }
    
    this.addFuncionarios(lista);
    })
    .catch(err => {
    // trata se alguma das promises falhar
    console.error('Erro ao listar funcionários!', err);
    });
}
window.onload = listarFuncionarios();
