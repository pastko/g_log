import { useState } from "react";
import AuthTemplate from "../auth/AuthTemplate";
import AuthForm from "../auth/AuthForm";
import axios from "axios";

const Register = ({ setIsOpen }) => {
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
    console.log("register");
    // await axios.post('https://localhost:8080/signup', {
    //     mail: isForm.mail,
    //     pwd: isForm.pwd,
    //     nikNm: isForm.nikNm
    // })
    // .then(res => {
    //     console.log(res);
    // })
    // .catch(error => {
    //     console.log(error);
    //     throw new Error(error);
    // });
  };

  return (
    <AuthTemplate setIsOpen={setIsOpen}>
      <AuthForm
        isRegister={true}
        goAction={goAction}
        onChangeHandler={onChangeHandler}
      />{" "}
    </AuthTemplate>
  );
};

export default Register;
