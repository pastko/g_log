import styled from "styled-components";

function Images({src, size}) {
    const tmp = src.split('.');
    const alt = tmp[0];

    return (
        <StyledImage src={`${process.env.s3URL}${src}`} alt={alt} width={size} height={size} />
    );
}

const StyledImage = styled.img`
    display: inline-block;
`;

export default Images;