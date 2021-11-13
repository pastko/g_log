import { useState } from "react";
import AuthTemplate from "../auth/AuthTemplate";
import AuthForm from "../auth/AuthForm";
import styled from "styled-components";

const SignIn = ({ setIsOpen }) => {
  return (
    <AuthTemplate setIsOpen={setIsOpen}>
      <AuthForm
        isRegister={false}
      />
    </AuthTemplate>
  );
};

export default SignIn;
