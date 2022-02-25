import axios from "axios";

export function getCoachData(setReceived, setFullName, setImage, setEmail, setSpeciality){
    axios.get(`http://localhost:8000/api/coach/me`
        , {
            headers: {
                "Authorization": `${localStorage.getItem("currentUser")}`
            }
        }
    ).then(
        (res) => {
            setReceived(true);
            setFullName(res.data.firstName + " " + res.data.lastName);
            setImage(res.data.image);
            setEmail(res.data.email);
            setSpeciality(res.data.speciality);
            console.log("res");
            console.log(res.data);
            // alert("hh");
            // goto("/this_link_is_not_yet_defined");
        }
        ,
        (err) => {
            alert("erreur lors de l'acces à vos données, en cas de besoin contacter l'admin");
            console.error(err);
        }
    );
}