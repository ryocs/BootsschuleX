export interface Category {
  id: number;
  name: string;
  totalQuestions: number;
  correctlyAnswered: number;
  progressText: string;
}

export interface Option {
  id: number;
  text: string;
}

export interface Question {
  id: number;
  text: string;
  options: Option[];
  message?: string;
}

export interface AnswerResult {
  isCorrect: boolean;
  correctOptionId: number;
}