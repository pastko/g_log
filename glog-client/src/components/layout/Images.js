import styled from "styled-components";

function Images({ src, width, height }) {
  const tmp = src.split(".");
  const alt = tmp[0];
  console.log('process ::: ', process.env.IMG_PATH);
  return (
    <StyledImage
      src={`${process.env.IMG_PATH}${src}`}
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
