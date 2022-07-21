import React, {FC} from 'react';

interface CustomInputProps{
    value?: string | number;
    onChange?: () => void;
    type: string;
    placeholder?: string;

}

const CustomInput:FC<CustomInputProps> = (props) => {
    return <input className={"text-gray-500 border-none text-base outline-none w-full"} {...props} />;
}

export default CustomInput;