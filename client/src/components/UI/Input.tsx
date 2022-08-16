import React, {FC} from 'react';

interface CustomInputProps{
    value?: string | number;
    onChange?: () => void;
    type: string;
    placeholder?: string;
    className?: string

}

const Input:FC<CustomInputProps> = ({className, ...props}) => {
    const rootClasses = ["text-gray-500 border-none text-base outline-none w-full dark:bg-transparent", className].join(" ")
    return <input className={rootClasses} {...props} />;
}

export default Input;