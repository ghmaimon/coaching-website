
import { jsx, css } from "@emotion/core";
import React from "react";
import LineIcon from "../css/lines.png";

const Icon = () => <img css={styles} src={LineIcon} />;

const styles = css`
  margin: 20px 0;
`;

export default Icon;
