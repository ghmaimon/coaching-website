import axios from "axios";
import {goto} from "./utils";

export function addOfferService(event, setSuccessful, tags) {
    event.preventDefault();
    const tempData = new FormData(event.currentTarget);
    for (let i of tempData.entries())
        console.log(i);
    let data =  new FormData();
    data.append('title', tempData.get('title'));
    data.append('description', tempData.get('description'));
    data.append('minPrice', tempData.get('minPrice'));
    data.append('maxPrice', tempData.get('maxPrice'));
    data.append('image', tempData.get('image'));
    data.append('tags', JSON.stringify(tags));


    axios.post(`http://localhost:8000/api/offer/add`, data
        , {
            headers: {
                "Authorization": `${localStorage.getItem("currentUser")}`
            }
        }
    ).then(
        (res) => {

            setSuccessful(true);
            console.log(res);
            // goto("/this_link_is_not_yet_defined");
        }
        ,
        (err) => {
            alert("erreur lors de l'ajout de l'offre, veuillez reentrer vos données, en cas de besoin contacter l'admin");
            console.error(err);
        }
    );
}