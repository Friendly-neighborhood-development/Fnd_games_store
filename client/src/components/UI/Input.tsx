import React, {FC} from 'react';

interface CustomInputProps {
    value?: string | number;
    onChange?: () => void;
    type: string;
    placeholder?: string;
    className?: string
    label?: string

}

const Input: FC<CustomInputProps> = ({className, label, ...props}) => {
    const rootClasses = ["px-2 text-gray-500 outline-none w-full dark:text-slate-400 dark:bg-slate-900 text-sm", className].join(" ")
    return (
        <>
            {label
                ? <label className={"text-sm"}>
                    {label}
                    <input className={rootClasses} {...props} />
                </label>
                : <input className={rootClasses} {...props} />
            }

        </>

    )
}

export default Input;