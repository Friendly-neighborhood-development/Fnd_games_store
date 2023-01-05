import React from "react";
import {IIcon} from "./IIcon";

export interface ITheme {
    id: string,
    title: "light" | "dark" | "system"
    Icon: React.FC<IIcon>
}