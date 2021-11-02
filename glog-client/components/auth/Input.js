import styled from 'styled-components';

function Input({ message, ...rest }) {
    return (
        <Block>
            <input placeholder={message} {...rest} />
        </Block>
    );
}

const Block = styled.div`
 input {
  display: block;
  width: 100%;
  height: 50px;
  line-height: 20px;
  font-size: 16px;
  padding: 15px;
  margin-bottom: 10px;
  border: 2px solid #ddd;
  border-radius: 1rem;
  &:focus {
   outline: 3px solid #caa1f6;  
  }  
 }
`;

export default Input;
