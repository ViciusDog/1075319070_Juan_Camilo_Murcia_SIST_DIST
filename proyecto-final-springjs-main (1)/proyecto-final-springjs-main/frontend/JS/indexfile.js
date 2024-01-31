const absoluteRoute = 'http://localhost:9090/api';
var person = {
    "identification": undefined,
    "doc_type": undefined,
    "names": undefined,
    "surname": undefined,
    "birthday": undefined,
    "working_on": undefined,
    "email": undefined,
    "saves_percent": undefined
};

var registro = {
    "id": undefined,
    "person_id": undefined,
    "earns": undefined,
    "spends": undefined,
    "created_at": undefined
};

var comment = {
    "id": undefined,
    "description": undefined,
    "details_id": undefined,
    "created_at": undefined,

};

var resumen = {
    "id": undefined,
    "person_id": undefined,
    "created_at": undefined,
    "utilities": undefined,
    "saves": undefined
}

function Select(ruta) {
    return fetch(ruta)
    .then(response => {
        if (!response.ok) {
            throw new Error(`Error: ${response.status}`);
        }
        return response.json();
    })
    .catch(error => {
        console.error('Error:', error);
        throw error;
    });
}

function Create(ruta, newData) {
    return fetch(ruta, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(newData),
    })
    .then(response => response.json())
    .catch(error => {
        console.log('Error en createData:', error);
        throw error;
    });
}

function Update(ruta, updatedData) {
    return fetch(`${ruta}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(updatedData),
    })
    .then(response => response.json());
}


function showPersonInfo() {
    const id = document.getElementById("identification").value;
    const showData = document.getElementById("results");
    const records = document.getElementById("records");
    const stats = document.getElementById("stats");
    const comments = document.getElementById("comments");

    stats.innerHTML = ``;
    records.innerHTML = ``;
    showData.innerHTML = ``;
    comments.innerHTML = ``;

    const data = Select(absoluteRoute + `/person-data/${id}`)
    .then(data => {
        
        if (data['identification'] == null || data['identification'] == undefined) return;
        showData.innerHTML = `
            <ul class="ms-2" id="person-info">
                <li class="text-center"><b>Información del Usuario</b></li>
                <ul>
                    <li>Nombre: ${data['names']} ${data['surname']}</li> <!--Nombre y Apellido-->
                    <li>Identificación: ${data['doc_type']} ${data['identification']}</li> <!--Tipo Identificación / Identificación-->
                    <li>Fecha de Nacimiento: ${data['birthday']}</li> <!--Fecha de nacimiento de la persona.-->
                    <li>Tipo de Cargo: ${data['working_on']}</li> 
                    <li>Correo Electrónico: ${data['email']}</li> <!--Correo Electrónico de la persona-->
                    <li>Porcentaje de Ahorro Ideal: ${data['saves_percent']}%</li> <!--Porcentaje de ahorros.-->
                </ul>
            </ul>
            `;
        records.innerHTML = `
        <h2>Registros hechos por el usuario</h2>
        <table class="table table-dark text-light table-striped">
            <thead>
                <th scope="col">Fecha</th>
                <th scope="col">Ingresos</th>
                <th scope="col">Egresos</th>
                <th scope="col">Acciones</th>
            </thead>
            <tbody id="record-body"></tbody>
        </table>
        
        <label for="agregar-comentario">¿Deseas agregar un nuevo registro?</label>
        <div class="input-group mb-5">
            <input class="form-control" type="number" name="ingresos" id="ingresos" placeholder="Ingresa el ingreso de la fecha">
            <input class="form-control" type="number" name="egresos" id="egresos" placeholder="Ingresa el egreso de la fecha">
            <button class="btn btn-primary" onclick="subirRegistro(${data['identification']})">Agregar Registro</button>
        </div>
        `;

            const recordsBody = document.getElementById("record-body");
            data['registros'].forEach(record => {
                recordsBody.innerHTML += `
                <tr>
                    <!--Información-->
                    <td>${record.created_at}</td>
                    <td>${record.earns}</td>
                    <td>${record.spends}</td>
                    <td><button class="btn btn-success" onclick="verComentarios(${record.id})">Ver Comentarios</button></td>
                </tr>
                `;
            });
        


        //Sección de Estadísticas de la persona.
            stats.innerHTML = `
                <h2>Estadísticas por registro.</h2>
                <table class="table table-dark text-light table-striped">
                    <thead>
                        <th scope="col">Fecha Registro</th>
                        <th scope="col">Utilidades</th>
                        <th scope="col">Ahorros</th>
                    </thead>
                    <tbody id="stats-body"></tbody>
                </table>
            `;
            const statsBody = document.getElementById("stats-body");
            let sum = 0;
            data['estadisticas'].forEach(record => {
                statsBody.innerHTML += `
                    <tr>
                        <!--Información-->
                        <td>${record.created_at}</td>
                        <td>${record.utilities}</td>
                        <td>${record.saves}</td>
                    </tr>
                `;
                sum += record.saves;
            });
            statsBody.innerHTML += `
                <tr>
                    <td></td>
                    <td><b>Total</b></td>
                    <td>${sum}</td>
                </tr>
            `;

        });
        
}

function createPerson() {
    const id = document.getElementById("identification").value;
    const isCreated = Select(absoluteRoute + `/person-data/${id}`).then(data => {
        if (data['id'] != undefined) {
            alert('Persona creada con anterioridad');
            return;
        }
    });
    let formPerson = document.getElementById("newperson");
    let personData = new FormData(formPerson);

    personData.forEach(function (value, key) {
        if (key === 'documentType') {
            person['doc_type'] = value;
        }
        else if (key === 'savesPercent') {
            person['saves_percent'] = value;
        }
        else if (key === 'workingOn') {
            person['working_on'] = value;
        }
        else {
            person[key] = value;
        }
    });

    Create(absoluteRoute + "/person-data/create", person);
    alert('Persona creada con éxito');
    console.log(person);
}

function verComentarios(record) {
    const comments = document.getElementById("comments");
    comments.innerHTML = `
        <h1>Comentarios realizados del registro de la fecha seleccionada</h1>
        <table class="table table-striped table-dark">
            <thead>
                <th scope="col">Fecha de Registro</th>
                <th scope="col">descripción</th>
                
            </thead>
            <tbody id="comment-body">

            </tbody>
        </table>
    `;
    const commentBody = document.getElementById("comment-body");
    Select(absoluteRoute + `/person-data/records/${record}`)
    .then(record => {
        console.log(record);
        record['comentarios'].forEach(comentario => {
            console.log(comentario);
            commentBody.innerHTML += `
                <tr>
                    <td>${comentario.created_at}</td>
                    <td>${comentario.description}</td>
                </tr>
            `;
        });
    
        comments.innerHTML += `
            <label for="agregar-comentario">¿Deseas agregar un nuevo comentario a este registro?</label>
            <div class="input-group mb-5">
                <input class="form-control" type="text" name="agregar-comentario" id="new-comment" placeholder="Ingresa un nuevo comentario">
                <button class="btn btn-primary" onclick="subirComentario(${record['id']})">Agregar Comentario</button>
            </div>
        `;
    });

}

function subirComentario(record_id) {
    const nuevoComentario = document.getElementById("new-comment").value;
    comment['description'] = nuevoComentario;
    console.log(comment);
    Create(absoluteRoute + `/person-data/records/${record_id}/create`, comment);
    alert('Comentario creado. Favor actualizar');
}

function subirRegistro(person_id) {
    registro['earns'] = document.getElementById("ingresos").value;
    registro['spends'] = document.getElementById("egresos").value;
    Create(absoluteRoute + `/person-data/${person_id}/newRecord`, registro);
    alert('Registro agregado.');
    window.location.href = './index.html';
}

function buscarUsuario() {
    const id = document.getElementById('search-id').value;
    const uploadButton = document.getElementById('update-button');
    console.log(id);
    if (id == '' || id == undefined) {
        clear();
        uploadButton.innerHTML = `
                <button class="btn btn-primary form-control" onclick="createPerson()">Enviar</button>
        `;
        return;
    }
    Select(absoluteRoute + `/person-data/${id}`).then( person => {
        if (person['identification'] == null || person['identification'] == undefined) {
            alert('Persona no encontrada');
            uploadButton.innerHTML = `
                <button class="btn btn-primary form-control" onclick="createPerson()">Enviar</button>
            `;
            return;
        }

        document.getElementById('identification').value = person['identification'];
        document.getElementById('documentType').selected = person['doc_type'];
        document.getElementById('names').value = person['names'];
        document.getElementById('surname').value = person['surname'];
        document.getElementById('workingOn').value = person['working_on'];
        document.getElementById('email').value = person['email'];
        document.getElementById('savesPercent').value = person['saves_percent'];
        document.getElementById('birthday').value = person['birthday'];
        uploadButton.innerHTML = `
                <button class="btn btn-warning form-control" onclick="actualizarUsuario()">Actualizar Usuario</button>
        `;
    })
    .catch(error => console.log(error));
}

function actualizarUsuario() {
    const id = document.getElementById("identification").value;
    const isCreated = Select(absoluteRoute + `/person-data/${id}`).then(data => {
        if (data['id'] != undefined) {
            alert('Persona creada con anterioridad');
            return;
        }
    });
    let formPerson = document.getElementById("newperson");
    let personData = new FormData(formPerson);

    personData.forEach(function (value, key) {
        if (key === 'documentType') {
            person['doc_type'] = value;
        }
        else if (key === 'savesPercent') {
            person['saves_percent'] = value;
        }
        else if (key === 'workingOn') {
            person['working_on'] = value;
        }
        else {
            person[key] = value;
        }
    });

    console.log(person);
    Update(absoluteRoute + `/person-data/actualizar/${id}`, person);
    clear();
    alert('Cambios realizados');
    
    //window.location.href = './index.html';
}

function clear() {
    const updateButton = document.getElementById('update-button');
    uploadButton.innerHTML = `
                <button class="btn btn-primary form-control" onclick="createPerson()">Enviar</button>
        `;
    document.getElementById('identification').value = '';
    document.getElementById('documentType').selected = '';
    document.getElementById('names').value = '';
    document.getElementById('surname').value = '';
    document.getElementById('workingOn').value = '';
    document.getElementById('email').value = '';
    document.getElementById('savesPercent').value = '';
    document.getElementById('birthday').value = '';

}