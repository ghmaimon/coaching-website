import axios from "axios";
import {goto} from "./utils";

export function addOfferService(event, setSuccessful, tags) {
    event.preventDefault();
    const data = new FormData(event.currentTarget);
    data.append('tags', tags);
    axios.post(`http://localhost:8000/api/account/create/coach`, data, {
            headers: {
                Authorization: localStorage.getItem("currentUser")
            }
        }
    ).then(
        (res) => {

            setSuccessful(true);
            console.log(res);
            goto("/this_link_is_not_yet_defined");
        }
        ,
        (err) => {
            alert("erreur lors de l'ajout de l'offre, veuillez reentrer vos données, en cas de besoin contacter l'admin");
            console.error(err);
        }
    );
}