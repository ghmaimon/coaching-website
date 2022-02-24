import axios from "axios";
import {goto} from "./utils";

const signUpService = (event,setSuccessful,isCoach) => {
    event.preventDefault();
    const data = new FormData(event.currentTarget);
    if (isCoach)
        createCoach(data,setSuccessful);
    else createClient(data,setSuccessful);
}
const createClient = (data,setSuccessful) => {
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

            setSuccessful(true);
            console.log(res);
            goto("/signin");
        }
        ,
        (err) => {
            alert("erreur lors de l'authentification, veuillez reentrer vos données, en cas de besoin contacter l'admin");
            console.error(err);
        }
    );

};

const createCoach = (data,setSuccessful) => {
    let tempData = new FormData();
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

            setSuccessful(true);
            console.log(res);
            goto("/signin");
        }
        ,
        (err) => {
            alert("erreur lors de l'authentification, veuillez reentrer vos données, en cas de besoin contacter l'admin");
            console.error(err);
        }
    );

};



export {signUpService};