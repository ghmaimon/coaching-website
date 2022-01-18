import React from "react";
import Title from "./Title";
import GitHubIcon from '@mui/icons-material/GitHub';
import Grid from "@mui/material/Grid";
import IconButton from '@mui/material/IconButton';
import LinkedInIcon from '@mui/icons-material/LinkedIn';

export default function OneCard(props) {
  return (
    <div style={{ marginTop: "20%", marginBottom: "20%" }}>
      <Grid
        container
      >
        <Grid item container direction="column" xs={2}>
          <Grid item md={2} xs={2}>
            <IconButton onClick={() => window.open(props.github)} >
              <GitHubIcon color="success" />
            </IconButton >
          </Grid>
          <Grid item md={2} xs={2} >
            <IconButton onClick={() => window.open(props.LinkedIn)} >
              <LinkedInIcon color="success" />
            </IconButton >
          </Grid>

        </Grid>
        <Grid item xs={6} md={6}>
          <Title name={props.name} img={props.photo} />
        </Grid>

      </Grid>
    </div>

  );
}
