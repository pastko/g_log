import { useState } from "react";
import AuthTemplate from "../auth/AuthTemplate";
import AuthForm from "../auth/AuthForm";
import styled from "styled-components";

const SignIn = ({ setIsOpen }) => {
  const [isForm, setForm] = useState({
    mail: "",
    pwd: "",
    confirmPwd: "",
    nikNm: "",
  });

  //TODO ::// ==>>
  const onChangeHandler = (e) => {
    const { name, value } = e.target;
    setForm({
      ...isForm,
      [name]: value,
    });
  };
  const goAction = () => {
    console.log("Login");
    // await axios
    //     .post('https://localhost:8080/signin', {
    //         mail: isForm.mail,
    //         pwd: isForm.pwd,
    //     })
    //     .then((res) => {
    //         console.log(res);
    //     })
    //     .catch((error) => {
    //         console.log(error);
    //         throw new Error(error);
    //     });
  };

  return (
    <AuthTemplate setIsOpen={setIsOpen}>
      <AuthForm
        isRegister={false}
        goAction={goAction}
        onChangeHandler={onChangeHandler}
      />{" "}
    </AuthTemplate>
  );
};

export default SignIn;
