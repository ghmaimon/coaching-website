import * as React from 'react';
import Link from '@mui/material/Link';
import Typography from '@mui/material/Typography';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import email from '../../css/email.png'
import Image from '../Home/Image'
import './emailSent.css'


function Copyright(props) {
    return ( <
        Typography variant = "body2"
        color = "text.secondary"
        align = "center" {...props } > { 'Copyright © ' } 
        <Link color = "inherit"
        href = "" >
        MEET FITNESS</Link>{' '} { new Date().getFullYear() } { '.' } 
        </Typography >
    );
}

const theme = createTheme();

export default function SignIn() {

    return ( 
        <div className='es-container'>
            <img src={email} className='es-img'/>
            <h1 className='es-text'>A mail was sent to this Email address</h1>
        </div>
    );
}