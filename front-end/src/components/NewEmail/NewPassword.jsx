import React, {useState} from 'react';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import Link from '@mui/material/Link';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import axios from 'axios';
import { goto } from '../../service/utils';
import { Password } from '@mui/icons-material';
import { useParams } from 'react-router';

function Copyright(props) {
    return ( <Typography variant = "body2"
        color = "text.secondary"
        align = "center" {...props } > { 'Copyright © ' } <Link color = "inherit"
        href = "" >
        MEET FITNESS</Link>{' '} { new Date().getFullYear() } { '.' } </Typography >
    );
}

const theme = createTheme();

export default function SignIn(props) {
    const [pass1, setPass1] = useState('pass1');
    const [pass2, setPass2] = useState('pass2');

    let { userId } = useParams();

    const handleSubmit = (event) => {
        event.preventDefault();
        axios.put('http://127.0.0.1:8000/api/account/changePassword/'+userId,{newPass1: pass1, newPass2: pass2});
        goto("/");
    };

    const storePass1 = (event) => {
        setPass1(event.target.value)
    }
    const storePass2 = (event) => {
        setPass2(event.target.value)
    }

    return ( <ThemeProvider theme = { theme } >
        <Container component = "main"
        maxWidth = "xs" >
        <CssBaseline />
        <Box sx = {
            {
                marginTop: 12,
                display: 'flex',
                flexDirection: 'column',
                alignItems: 'center',
            }
        } >
        <Avatar sx = {
            { m: 1, bgcolor: '#2e7d32' }
        } >
        <LockOutlinedIcon />
        </Avatar> <Typography component = "h1"
        variant = "h5"
        color = "#2e7d32" >
        Forgot password
        </Typography> 
        <Box component = "form"
        noValidate sx = {
            { mt: 1 }
        } >
        <TextField margin = "normal"
        onChange={storePass1}
        type = "password"
        value={pass1}
        required fullWidth id = "pass1"
        label = "password"
        color = "success"
        autoFocus />
        <TextField margin = "normal"
        type = "password"
        onChange={storePass2}
        value={pass2}
        required fullWidth id = "pass2"
        label = "password Confirmation "
        color = "success"
        autoFocus />
        
        <Button type = "submit"
        href = "/EmailSent"
        fullWidth variant = "contained"
        onClick= { handleSubmit }
        color = "success"
        sx = {
            { mt: 3, mb: 2 }
        } >
        Changer </Button> 
        </Box > </Box> <Copyright sx = {
            { mt: 8, mb: 4 }
        }
        /> </Container > </ThemeProvider>
    );
}