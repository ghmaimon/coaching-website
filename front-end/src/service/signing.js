import axios from "axios";
import {goto} from "./utils";

const signUpService = (event) => {
    event.preventDefault();
    const data = new FormData(event.currentTarget);
    // createClient(data);
    createCoach(data);
}
const createClient = (data) => {
    const dataToSend = {
        firstName: data.get('firstName'),
        lastName: data.get('lastName'),
        email: data.get('email'),
        password: data.get('password'),
        birth_date : data.get("date")
    }
    console.log("data");
    console.log(dataToSend);
    axios.post(`http://localhost:8000/api/account/create/client`, dataToSend, {
        headers: {
            'Content-Type': 'application/json',
        }
    }).then(
        (res) => {

            // setSuccessful(true);
            console.log(res);
            // goto("/");
        }
        ,
        (err) => {
            alert("erreur lors de l'authentification, veuillez reentrer vos données, en cas de besoin contacter l'admin");
            console.error(err);
        }
    );

};

const createCoach = (data) => {
    let tempData = new FormData();
    // const dataToSend = {
    //     firstName: data.get('firstName'),
    //     lastName: data.get('lastName'),
    //     email: data.get('email'),
    //     password: data.get('password'),
    //     birth_date : data.get("date"),
    //     image: data.get("image"),
    //     coachingCertificate : data.get("certificate"),
    //     identityDocument: data.get("cin")
    // }
    tempData.append("firstName", data.get('firstName'));
    tempData.append("lastName", data.get('lastName'));
    tempData.append("email", data.get('email'));
    tempData.append("password", data.get('password'));
    tempData.append("birth_date", data.get('date'));
    tempData.append("image", data.get('image'));
    tempData.append("coachingCertificate", data.get('certificate'));
    tempData.append("identityDocument", data.get('cin'));
    axios.post(`http://localhost:8000/api/account/create/coach`, tempData
    ).then(
        (res) => {

            // setSuccessful(true);
            console.log(res);
            // goto("/");
        }
        ,
        (err) => {
            alert("erreur lors de l'authentification, veuillez reentrer vos données, en cas de besoin contacter l'admin");
            console.error(err);
        }
    );

};



export {signUpService};