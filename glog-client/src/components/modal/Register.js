import AuthTemplate from "../auth/AuthTemplate";
import AuthForm from "../auth/AuthForm";

const Register = ({ setIsOpen }) => {
  return (
    <AuthTemplate setIsOpen={setIsOpen}>
      <AuthForm
        isRegister={true}
      />
    </AuthTemplate>
  );
};

export default Register;
