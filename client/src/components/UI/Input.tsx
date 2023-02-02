import React, {FC} from 'react';

interface CustomInputProps {
    value?: string | number;
    onChange?: (arg0: React.FormEvent<HTMLInputElement>) => any;
    type: string;
    placeholder?: string;
    className?: string
    label?: string
    autoComplete?: "new-password" | "username" | "password" | "no" | "on"
    onFocus?: () => any
    required?: boolean
}

export const Input: FC<CustomInputProps> = ({className, label, required, ...props}) => {
    const rootClasses = ["px-2 outline-none w-full dark:text-slate-200 text-sm", className].join(" ")
    return (
        <>
            {label
                ? <label className={"text-sm"}>
                    {label}
                    {required ? <span className={"text-red-400"}> *</span> : <></>}
                    <input required={required} className={rootClasses} {...props}  />
                </label>
                : <input className={rootClasses} {...props} />
            }
        </>
    )
}

