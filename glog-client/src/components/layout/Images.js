import styled from "styled-components";

function Images({ src, width, height, shape }) {
  const tmp = src.split(".");
  const alt = tmp[0];

  const styles = {
    src: `${process.env.REACT_APP_IMG_PATH}${src}`,
    alt: alt,
    width: width,
    height: height,
  };

  if (shape === "circle") {
    return <StyledCircleImage {...styles} />;
  } else {
    return <StyledImage {...styles} />;
  }
}

const StyledCircleImage = styled.img`
  display: inline-block;
  border-radius: 50%;
`;
const StyledImage = styled.img`
  display: inline-block;
`;

export default Images;
