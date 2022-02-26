import React from "react";
import MyButton from "../../../shared/MyButton";
import { makeStyles } from "@mui/styles";
import PersonAddIcon from "@mui/icons-material/PersonAdd";
import SettingsIcon from "@mui/icons-material/Settings";
import ButtonLogin from "../../../shared/ButtonLogin";
import {getId} from "../../../service/personalData";
const useStyles = makeStyles({
  root: {
    float: "left",
    position: "absolute",
    marginLeft: "12%",
    fontFamily: "Cascadia Code",
  },
  secondary: {
    float: "left",
    position: "absolute",
    marginLeft: "12%",
    fontFamily: "Cascadia Code",
    paddingRight: "2%",

  },
  third: {
    float: "left",
    position: "absolute",
    fontFamily: "Cascadia Code",
    paddingRight: "2%",
  },
  fourth: {
    float: "right",
    position: "absolute",
    fontFamily: "Cascadia Code",
    paddingRight: "7%",
  },
  fifth: {
    float: "right",
    position: "absolute",
    fontFamily: "Cascadia Code",
    paddingRight: "4.5%",
  },
});


function Coaches() {
  let style = useStyles();
  return (
    <MyButton
      bgColor="#3FA437"
      fgColor="white"
      className={style.secondary}
      value="Coaches documents"
      url="/admin/coaches_documents"
    />
  );
}
function Disputes() {
  let style = useStyles();

  return (
    <MyButton
      bgColor="#FBEEC1"
      fgColor="black"
      className={style.secondary}
      value="Dispute Management"
      url="/admin/disputes"
      marginTop="-1%"
    />
  );
}
function DeleteButton() {
  let style = useStyles();
  return (
    <MyButton
      bgColor="#c81236"
      fgColor="white"
      className={style.third}
      startIcon={<PersonAddIcon />}
      value="Supprimer mon Compte"
      size="13px"
    />
  );
}
function ChangePassword(props) {
  let style = useStyles();
  return (
    <MyButton
      bgColor="#7e7e7e"
      fgColor="white"
      className={style.fifth}
      startIcon={<SettingsIcon />}
      value="Change Password"
      // url={`/NewPassword/${props.id}`}
      onClick = {getId}
      size="13px"

    />
  );
}
function AddButton() {
  let style = useStyles();
  return (
    <MyButton
      bgColor="#4c9a2a"
      fgColor="white"
      className={style.fourth}
      startIcon={<PersonAddIcon />}
      value="Add an admin"
      url="/admin/newAdmin"
      size="13px"
    />
  );
}
export { Coaches, Disputes, DeleteButton, AddButton, ChangePassword };
