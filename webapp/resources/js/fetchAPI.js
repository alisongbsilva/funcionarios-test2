
  URL_TO_FETCH = "http://localhost:8080/funcionarios-test2/rs/funcionario/2/";

  fetch(URL_TO_FETCH)
  .then(response => response.json()) // retorna uma promise
  .then(result => {
    console.log(result);
  })
  .catch(err => {
    // trata se alguma das promises falhar
    console.error('Failed retrieving information', err);
  });

