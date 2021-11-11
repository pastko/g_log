import styled from "styled-components";

function Images({ src, width, height }) {
  const tmp = src.split(".");
  const alt = tmp[0];
  return (
    <StyledImage
      src={`${process.env.REACT_APP_IMG_PATH}${src}`}
      alt={alt}
      width={width}
      height={height}
    />
  );
}

const StyledImage = styled.img`
  display: inline-block;
`;

export default Images;
