import AuthTemplate from "../auth/AuthTemplate";
import AuthForm from "../auth/AuthForm";

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
